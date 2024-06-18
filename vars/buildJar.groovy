#!/user/bin/env groovy

def call() {
    echo 'Building .net App ...'
    sh 'mvn package'
}
