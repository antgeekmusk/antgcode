package com.antg.toolbox;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author:Antg
* @create: 2023/9/14
* @Description:
 * 整理字典表的时候,枚举值太多不可能一个一个去cv,所以设计一个自动化程序来解析枚举值并生成一个字典文件
*/
public class EnumScanUtil {
    static Pattern pattern = Pattern.compile("^[A-Z_]+\\((.*)\\)[,|;]$");
    public static void main(String[] args) {
        String directoryPath = "~/IdeaProjects/";
        String targetFile="~/enum_list.txt";
        scanEnums(directoryPath,targetFile);

    }

    /**
    * @author:Antg
    * @create: 2023/9/15
    * @Description: scan files
    */
    public static void scanEnums(String directoryPath,String targetFile) {
        File folder = new File(directoryPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("指定的路径不是一个有效的目录");
            return;
        }

        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                extractEnumInfoAndWrite(file,targetFile);
            } else if (file.isDirectory()) {
                scanEnums(file.getAbsolutePath(),targetFile);
            }
        }
    }

    /**
    * @author:Antg
    * @create: 2023/9/15
    * @Description: parse enum
    */
    public static void extractEnumInfoAndWrite(File file,String targetFile) {
        try {
            String content = FileUtil.readString(file.getAbsoluteFile(), CharsetUtil.CHARSET_UTF_8);
            String packageName = extractPackageName(content);
            String className = extractClassName(file.getName());
            String serviceName = extractServiceName(packageName);
            Map<String, String> map = extractEnumValue(content);
            if(map!=null && map.size()!=0){
                for (Map.Entry<String, String> ele : map.entrySet()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(serviceName)
                            .append("|")
                            .append(packageName)
                            .append("|")
                            .append(className)
                            .append("|")
                            .append(ele.getKey())
                            .append("|")
                            .append(ele.getValue())
                            .append("\n");
                    FileUtil.appendString(sb.toString(),targetFile,CharsetUtil.CHARSET_UTF_8);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * @author:Antg
    * @create: 2023/9/14
    * @Description: get package name
    */
    public static String extractPackageName(String content) {
        String[] lines = content.split("\\n");
        String packageName = "";
        for (int i = 0; i < Math.min(lines.length, 3); i++) {
            if (lines[i].contains("package")) {
                int startIndex = lines[i].indexOf("package") + 8; // 获取"package"后面的字符的起始位置
                int endIndex = lines[i].indexOf(";"); // 获取第一个换行符的位置
                packageName = lines[i].substring(startIndex, endIndex); // 获取子字符串
                break;
            }
        }
        return packageName.trim();
    }

    /**
    * @author:Antg
    * @create: 2023/9/14
    * @Description: get service name
    */
    public static String extractServiceName(String packageName) {
        if(packageName==null) return "";
        String[] split = packageName.split("\\.");
        if(split.length>=3){
            return split[2];
        }else{
            return "";
        }
    }

    /**
    * @author:Antg
    * @create: 2023/9/15
    * @Description: use file name get classname
    */
    public static String extractClassName(String fileName) {
        // 从文件名中提取类名信息
        // 这里假设文件名与类名一致，不包含后缀
        String[] split = fileName.substring(0, fileName.lastIndexOf('.')).split("/");
        return split[split.length-1];
    }

    /**
    * @author:Antg
    * @create: 2023/9/15
    * @Description: parse enum, get enum code and message
    */
    public static Map<String,String> extractEnumValue(String content) {
        Map<String,String> map = new HashMap<>();

        String[] lines = content.split("\n");


        for (String line : lines) {
            Matcher matcher = pattern.matcher(line.trim());
            if (matcher.find()) {
                String[] split = matcher.group(1).replace("\"", "").split(",");
                if(split.length==2){
                map.put(split[0],split[1]);
                }else if(split.length==1){
                    map.put(split[0],"");
                }else if(split.length>2){
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < split.length; i++) {
                        sb.append(split[i]).append(" | ");
                    }
                }
                // until last ; then stop scan
                if(line.trim().endsWith(";")){
                    break;
                }
            }

        }
        
        return map;
    }
}
