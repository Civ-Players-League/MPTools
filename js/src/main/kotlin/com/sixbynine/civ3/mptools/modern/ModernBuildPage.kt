package com.sixbynine.civ3.mptools.modern

import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.styles.*
import com.sixbynine.civ3.mptools.resources.strings
import itemList
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.*
import styled.*

class ModernBuildPage : RComponent<RProps, AppState>() {
  private var refreshAutomatically = false

  private var loadingJob: Job? = null
  private var dataInitialized = false

  private var availableResources = mutableSetOf<ModernResource>()

  override fun RBuilder.render() {
    mCssBaseline()

    @Suppress("UnsafeCastFromDynamic")
    val themeOptions: ThemeOptions =
      js("({palette: { type: 'placeholder', primary: {main: 'placeholder'}}})")
    themeOptions.palette?.type = "light"
    themeOptions.palette?.primary.main = "#536DFE"

    mThemeProvider(createMuiTheme(themeOptions)) {
      styledDiv {
        css {
          padding(16.px)
        }

        mAppBar {
          mToolbar {
            mToolbarTitle(strings.whatCanIBuildInModern)
          }
        }

        modernResourceBox(availableResources) {
          setState {}
        }

        modernUnitsBox(availableResources)
      }
    }
  }

  override fun AppState.init() {
    items = null
    loading = true

    refreshLoadingJob()
  }

  private fun refreshLoadingJob() {
    loadingJob?.cancel()
    loadingJob = MainScope().launch {
      while (refreshAutomatically || !dataInitialized) {
        setState {
         items = listOf("Hello", "World")
        }
        dataInitialized = true
        delay(15_000)
      }
    }
  }
}

fun RBuilder.modernBuildPage(): ReactElement {
  return child(ModernBuildPage::class) {}
}

external interface AppState : RState {
  var items: List<String>?
  var loading: Boolean
}