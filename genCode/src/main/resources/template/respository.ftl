package ${packageName};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
  * ${tableDesc}Repository
  */
@Repository
public interface ${javaName}PORepository extends JpaRepository<${javaName}PO, ${keyType}>, JpaSpecificationExecutor<${javaName}PO> {

}