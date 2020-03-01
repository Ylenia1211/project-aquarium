package com.uge.j2ee.aquarium.repository;

        import com.uge.j2ee.aquarium.model.Animal;
        import com.uge.j2ee.aquarium.model.AnimalSpecies;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;

        import java.util.List;

public interface AnimalDetailRepository  extends CrudRepository<AnimalSpecies,Long> {

    @Query("select a.nameSpecies from animal_species a")
    List<String> getAllSpecies();

  /*  @Query("select fish.name from #{animalRepository} fish join animal_species where animal_species.idSpecies = fish.species")
    List<String> getAllAnimalBySpecies();*/
}
