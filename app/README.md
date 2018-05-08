Usage
----
1. 执行 gradle clean install //安装插件到本地maven仓库
2. 项目build文件中增加 
            
        classpath 'mobi.cangol.mobile:fir-gradle-plugin:1.2.0'
    
3. app模块build文件中增加   
        
        apply plugin: 'im.fir.plugin.gradle'
        fir{
            apiToken 'c5cddea79fbc9176a98e216c6f154022'
            changeLog '更新日志'
        }
    
4. 执行 gradle publishApkDebug
