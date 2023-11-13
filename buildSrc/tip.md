目前gradle中 对kotlin dsl scripts只能识别内置对一些脚本（如：build.gradle.kts、settings.gradle.kts），
无法对自定义kotlin dsl脚本进行识别，来建立引用关系

issues:https://github.com/gradle/gradle/issues/12640


buildSrc属于gradle项目的一个特殊目录，此目录下会自动执行
添加此目录一方面是便于一些调试测试，一方面由于上面提到的目前无法识别自定义脚本而带来的编写的不便利
