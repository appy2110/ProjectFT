pipeline{
    agent any
    stages{
        stage("Build"){
            steps{
                echo("build project")
            }
        }
        stage("deploy to dev"){
            steps{
                echo("deploy to dev")
            }
        }
        stage("Run UT's"){
            steps{
                echo("run Unit tests")
            }
        }
         stage("deploy to QA"){
            steps{
                echo("deploy to QA")
            }
        }
        stage("Run AT"){
            steps{
                echo("run automation tests")
            }
        }
        stage("deploy to Stage"){
            steps{
                echo("deploy to Stage")
            }
        }
        stage("Run ST"){
            steps{
                echo("run sanity tests")
            }
        }
         stage("deploy to prod"){
            steps{
                echo("deploy to prod")
            }
        }
    }
    
    
}