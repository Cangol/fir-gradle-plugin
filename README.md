[![Download](https://api.bintray.com/packages/cangol/maven/fir-gradle-plugin/images/download.svg) ](https://bintray.com/cangol/maven/fir-gradle-plugin/_latestVersion)
[![Build Status](https://travis-ci.org/Cangol/fir-gradle-plugin.svg?branch=master)](https://travis-ci.org/Cangol/fir-gradle-plugin)


Usage
-----------
        buildscript {
            repositories {
                jcenter()
            }
            dependencies {
                classpath 'com.android.tools.build:gradle:3.0.1'
                classpath 'mobi.cangol.mobile:fir-gradle-plugin:1.2.0'
            }
        }

        apply plugin: 'im.fir.plugin.gradle'
        
        fir{
            apiToken '替换为你的 fir.im API_TOKEN'   //必填 上传 fir.im apk 字段，否则无法上传 APP 到 fir.im
 
            changeLog '替换为你的更新日志'////可选 上传fir.im 中显示的changelog
        }
                
                
         './gradlew publishApkDebug
   
License
-----------

    Copyright 2012 Cangol

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
