package kodein.demo.coffee

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.singleton
import kodein.demo.Logger

public class Thermosiphon(private val log: Logger, private val heater: Heater) : Pump {

    init {
        log.log("<Creating Thermosiphon>")
    }

    override fun pumpWater() {
        if (heater.isHot)
            log.log("=> => pumping => =>");
        else
            log.log("!!! water is cold !!!");
    }
}

public val thermosiphonModule = Kodein.Module {
    bind<Pump>() with singleton { Thermosiphon(instance(), instance()) }
}
