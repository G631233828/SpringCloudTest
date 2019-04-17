package gjb.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@AllArgsConstructor // 全参构造
@NoArgsConstructor // 无参构造
@SuppressWarnings("serial")
@Accessors(chain = true)
@Data
public class Dept implements Serializable {

	private Long deptno;// 主键
	private String dbname;// 部门名称
	private String db_source;// 来自哪个数据库
	
	

}
