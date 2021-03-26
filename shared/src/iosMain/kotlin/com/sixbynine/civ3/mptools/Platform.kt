package com.sixbynine.civ3.mptools


import platform.UIKit.UIDevice

actual class Platform actual constructor() {
  actual val platform: String =
    UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}