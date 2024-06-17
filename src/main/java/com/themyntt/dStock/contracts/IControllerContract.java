package com.themyntt.dStock.contracts;

public interface IControllerContract<I, O> {
    O perform(I dto);
}
