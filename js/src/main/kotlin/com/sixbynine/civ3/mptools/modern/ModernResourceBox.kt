package com.sixbynine.civ3.mptools.modern

import com.ccfraser.muirwik.components.*
import com.sixbynine.civ3.mptools.resources.strings
import kotlinx.css.*
import react.*
import styled.*

class ModernResourceBox : RComponent<ModernResourceBoxProps, RState>() {

  override fun RBuilder.render() {
    mPaper {
      css {
        display = Display.flex
        marginTop = 72.px
        padding(16.px)
      }
      styledDiv {
        ModernResource.values().forEach {
          mCheckboxWithLabel(
            label = it.label,
            checked = it in props.availableResources,
            onChange = { _, checked ->
              setState {
                if (checked) {
                  props.availableResources.add(it)
                } else {
                  props.availableResources.remove(it)
                }
              }
              props.checkedChangeCallback.invoke()
            }
          )
        }
      }
    }
  }
}

external interface ModernResourceBoxProps : RProps {
  var availableResources : MutableSet<ModernResource>
  var checkedChangeCallback: () -> Unit
}

fun RBuilder.modernResourceBox(
  availableResources : MutableSet<ModernResource>,
  checkedChangeCallback: () -> Unit
): ReactElement {
  return child(ModernResourceBox::class) {
    attrs.availableResources = availableResources
    attrs.checkedChangeCallback = checkedChangeCallback
  }
}