package com.young.el.youngrepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.young.el.document.LocationDocument;

@Repository
public interface LocationRepository extends YoungRepository<LocationDocument,Long>{
	
	List<LocationDocument> findByCountyName(String countyName,Pageable pageable);
}
