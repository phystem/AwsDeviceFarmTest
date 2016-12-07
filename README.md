# AwsDeviceFarmTest

## To get Activity Nam
adb shell dumpsys activity activities | grep mFocusedActivity | cut -d . -f 5 | cut -d ' ' -f 1


## To Launch appium
appium --pre-launch --app-pkg com.example.phystem.simplequiz --app-activity MainActivity --platform-name Android --app sampleApp.apk --device-name AndroidDev


## To build zip-with-dependencies
clean package -DskipTests=true

## Reference
https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app
