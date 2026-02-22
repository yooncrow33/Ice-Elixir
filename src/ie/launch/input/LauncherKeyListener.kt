package ie.launch.input

import ie.launch.Launcher
import scope.KeyBindingBase
import javax.swing.JComponent

class LauncherKeyListener(comp : JComponent, var main: Launcher) : KeyBindingBase(comp) {
    override fun onKeyEnterPress() {
        if (main.sideBarFocus == 0) {if (main.mainFocus == 0) {main.launch()}}
    }

    override fun onKeyUpPress() {
        if (main.sideBarFocus == 0) {
            main.mainFocus = 0
        } else if (main.sideBarFocus == 1) {

        } else if (main.sideBarFocus == 2) {

        }
    }

    override fun onKeyLeftPress() {
        if (main.sideBarFocus == 0 && main.mainFocus == 1) {
            if (main.selectedProfile > 1) {
                main.selectedProfile--
            } else {
                main.selectedProfile = 3
            }
        } else if (main.sideBarFocus == 1) {

        } else if (main.sideBarFocus == 2) {

        }
    }

    override fun onKeyDownPress() {
        if (main.sideBarFocus == 0) {
            main.mainFocus = 1
        } else if (main.sideBarFocus == 1) {

        } else if (main.sideBarFocus == 2) {

        }
    }

    override fun onKeyRightPress() {
        if (main.sideBarFocus == 0 && main.mainFocus == 1) {
            if (main.selectedProfile < 3) {
                main.selectedProfile++
            } else {
                main.selectedProfile = 1
            }
        } else if (main.sideBarFocus == 1) {

        } else if (main.sideBarFocus == 2) {

        }
    }

    override fun onKeyLPress() {
        // 2보다 작으면 증가시키고, 2에 도달하면 0으로 복귀
        if (main.sideBarFocus < 2) {
            main.sideBarFocus++
        } else {
            main.sideBarFocus = 0
        }
    }

    override fun onKeyPPress() {
        // 0보다 크면 감소시키고, 0에 도달하면 2로 복귀
        if (main.sideBarFocus > 0) {
            main.sideBarFocus--
        } else {
            main.sideBarFocus = 2
        }
    }
}