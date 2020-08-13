package org.pipeline

//构建类型
def Build(buildType,buildShell){
    // 括号里面的mvn为执行的命令，maven为jenkins系统设置里定义的名称
    def buildTools = ["mvn":"maven","ant":"ant","gradle":"gradle","npm":"nodejs"]
    
    println("当前选择的构建类型为：${buildType}")
    buildHome = tool buildTools[buildType]
    
    // 判断tuild命令
    if ("${buildType}" == "npm"){
        sh """
            source /etc/profile
            ${buildHome}/bin/${buildType} ${buildshell}
            """
    } else {
        sh "${buildHome}/bin/${buildType} ${buildShell}"
    }
}
