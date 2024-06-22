#!/user/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo 'build docker Image using artifact...'
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin(){
        script.echo 'login into docker hub start...'
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
        }
    }

    def dockerPush(String imageName){
        script.echo 'pushing docker Image to dockerhub...'
        script.sh "docker push $imageName"
    }
}
