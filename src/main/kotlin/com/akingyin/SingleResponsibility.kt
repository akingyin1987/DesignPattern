package com.akingyin

/**
 *
 * 单一职责
 */
class SingleResponsibility {




    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            Vehicle().let {
                it.run("摩托车")
                it.run("汽车")
                it.run("飞机")
            }
        }
    }

    /**
     * 交通工具
     *
     */
    open class Vehicle{
       open fun run(vehicle:String){
            println("${vehicle}在公路上运行.....")
        }
    }

    /**
     * 路径上交通工具
     *
     */
    class RoadVehicle : Vehicle(){
        override fun run(vehicle: String) {
            println("${vehicle}在公路上运行.....")
        }
    }

    class AirVehicle:Vehicle(){
        override fun run(vehicle: String) {
            println("${vehicle}在天空上运行.....")
        }
    }
}