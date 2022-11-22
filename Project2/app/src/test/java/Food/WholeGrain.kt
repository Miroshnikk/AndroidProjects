package Food

class WholeGrain(environment: Servings, val isHealthy: Boolean, val kindOfProduct: String, val name: String) : Food(environment), Storage {


    override fun purpose(){
        TODO()
    }

    override fun healthBenefits(){
        println("Useful")
    }

    override fun freezer(){
        println("$name is stored in a freezer")
    }

    override fun fridge(){
        println("$name is stored in a fridge")
    }

    override fun room(){
        println("$name is stored in the room")
    }

    fun stringWholeGrainId(){
        println("Name: $name, healthy: $isHealthy, kind: $kindOfProduct, environment: $environment")
    }

    override fun Produtcs(environment: Servings) {
        super.Produtcs(environment)
    }

}