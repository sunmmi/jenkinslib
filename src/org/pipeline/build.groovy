package org.pipeline

//构建类型
def Build(buildType,buildShell){
    def buildTools = ["mvn":"maven","ant":"ant","gradle":"gradle","npm":"npm"]
    
    println("当前选择的构建类型为：${buildType}")
    buildHome = tool buildTools[buildType]
    
    if ("${buildType}" == "npm"){
        sh """
            source /etc/profile
            ${buildHome}/bin/${buildType} ${buildshell}
            """
    } else {
        sh "${buildHome}/bin/${buildType} ${buildShell}"
    }
}
