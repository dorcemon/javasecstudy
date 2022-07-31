package com.other.coll;

import org.junit.Test;

public  class GenericInterfaceImpl<E> implements GenericInterface<E> {
    @Override
    public void addData(E e) {

    }

    @Test
    public void test1(){
        GenericInterfaceImpl<User> userGenericInterface = new GenericInterfaceImpl<>();
    }

}

/*
class GenericChild extends GenericInterfaceImpl<User>{

    @Override
    public void addData(User user) {

    }
}
*/
