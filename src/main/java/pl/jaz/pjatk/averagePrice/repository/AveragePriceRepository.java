package pl.jaz.pjatk.averagePrice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaz.pjatk.averagePrice.model.EntryToDatabase;

@Repository
public interface AveragePriceRepository extends JpaRepository<EntryToDatabase, Long> {

}
