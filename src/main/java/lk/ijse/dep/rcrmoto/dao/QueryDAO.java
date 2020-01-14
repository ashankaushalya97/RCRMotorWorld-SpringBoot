package lk.ijse.dep.rcrmoto.dao;

import lk.ijse.dep.rcrmoto.entity.CustomEntity;

import java.util.List;

public interface QueryDAO {

    List<CustomEntity> getOrderInfo();

    List<CustomEntity> searchOrder(String text);


}
