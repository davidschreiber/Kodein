package com.github.salomonbrys.kodein.test
public  inline fun <reified T : Throwable> assertThrown(body: () -> Unit) {
    try {
        body()
    }
    catch (t: Throwable) {
        if (t is T)
            return
        throw t
    }
    throw AssertionError("Exepected ${T::class.java.name} to be thrown")
}
