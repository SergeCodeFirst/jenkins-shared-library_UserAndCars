#!/user/bin/env groovy

def call() {
    echo 'building a dotnet artifact...'
    sh 'dotnet clean'
    sh 'dotnet restore'
    sh 'dotnet publish -c Release'
}