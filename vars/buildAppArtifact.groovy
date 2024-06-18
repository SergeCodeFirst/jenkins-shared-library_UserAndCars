#!/user/bin/env groovy

def call() {
    echo 'building a dotnet artifact...'
    sh 'dotnet restore'
    sh 'dotnet publish -c Release'
}