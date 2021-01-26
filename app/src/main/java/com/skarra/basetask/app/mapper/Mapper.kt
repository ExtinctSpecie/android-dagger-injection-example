package com.skarra.basetask.app.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}