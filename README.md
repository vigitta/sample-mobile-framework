# To run the framework
### Pre-requisites
- JDK
- Android SDK
- Appium, UIAutomator2

1. Run the Appium server on your local with
   `appium server -p 4725 -a 127.0.0.1 -pa /wd/hub`
2. set the Device name property with your device name  (`utils.DriverUtils:18`)
3. Download the latest trust wallet APK and put it in the `src/apps/android/` directory, or set the 'app' capability with the path of the APK
4. Run the default test-suit file testng.xml by right-clicking and clicking Run (IntelliJ IDEA)
5. The test results will be available in the `test-outputs` directory with an HTML report and a screenshot directory