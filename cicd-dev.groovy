node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/promptersport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/promptersport.git'), string(name: 'PORT_DESCRIPTION', value: 'A collection, growing, of shell scripts to guide/prompt the use of various shell commands' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
