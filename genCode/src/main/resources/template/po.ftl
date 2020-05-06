package ${packageName};

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ${tableDesc}
 */
@Table(name = "${tableName}")
@Entity
@Data
public class ${javaName}PO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ${key.columnDesc}
     */
    @Id
    @Column(name = "${key.columnName}",  nullable = ${key.nullable})
    private ${key.javaType} ${key.javaName};

/**
* 箱体id
*/
@Column(name = "box_id", nullable = false)
private Integer boxId;

/**
* 高
*/
@Column(name = "high", nullable = false)
private Integer high;

/**
* 宽
*/
@Column(name = "weight", nullable = false)
private Integer weight;

/**
* 厚
*/
@Column(name = "thickness", nullable = false)
private Integer thickness;


}