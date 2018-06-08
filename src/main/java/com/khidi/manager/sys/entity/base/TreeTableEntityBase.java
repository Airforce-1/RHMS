package com.khidi.manager.sys.entity.base;

import java.io.Serializable;
import java.util.List;


/**@author shudewei
 * 用于规范树结构的实体显示，前端接口需要接受id，parentId，open，list
 */
public interface TreeTableEntityBase extends Serializable {

     String getParentId() ;

     void setParentId(String parentId);

     Boolean getOpen() ;

     void setOpen(Boolean open);

     List<?> getList();

     void setList(List<?> list);
}
