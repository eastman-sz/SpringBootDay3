package com.omfine.service;

import com.omfine.bean.Merchandise;
import java.util.List;

public interface MerchandiseService {

    int insert(Merchandise merchandise);

    List<Merchandise> selectAll();

}
