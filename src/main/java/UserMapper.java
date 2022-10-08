
import com.mybatis.annotation.Select;

import java.util.List;
import java.util.Map;


public interface UserMapper {

  @Select("select * from sys_user where username = #{name}")
  public  List<Map<String,Object>> selectAll(String name);
}
