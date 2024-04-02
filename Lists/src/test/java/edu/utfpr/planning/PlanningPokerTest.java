package edu.utfpr.planning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PlanningPokerTest {
    @Test
    public void manyEstimates() {

        List<Estimate> list1 = Arrays.asList(
            new Estimate("Ricardo", 10),
            new Estimate("Arie", 4),
            new Estimate("Felipe", 8),
            new Estimate("Victor", 12),
            new Estimate("João", 2)
        );

        List<Estimate> list2 = Arrays.asList(
            new Estimate("Mauricio",10),
            new Estimate("Arie", 5)
        );


        List<String> devs1 = new PlanningPoker()
            .identifyExtremes(list1);
        List<String> devs2 = new PlanningPoker()
            .identifyExtremes(list2);

        assertThat(devs1).isEqualTo(Arrays.asList("João", "Guilherme"));
        assertThat(devs2).isEqualTo(Arrays.asList("Arie", "Mauricio"));
    }
    @Test
    public void oneEstimate() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Mauricio",10)
        );

        assertThrows(NullPointerException.class, () -> {
            new PlanningPoker().identifyExtremes(list);
        });
    }
  
    @Test
    public void emptyList() {
        List<Estimate> list = Arrays.asList();


        
        assertThrows(NullPointerException.class, () -> {
            new PlanningPoker().identifyExtremes(list);
        });

    }
    @Test 
    public void nullList() {
        List<Estimate> list = new ArrayList<>();

        assertThrows(NullPointerException.class, () -> {
            new PlanningPoker().identifyExtremes(list);
        });
    }

    @Test 
    public void modifiedEstimates() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Mauricio",10),
            new Estimate("Arie", 5)
        );

      
        list.get(0).setEstimate(15);

        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);
      
        assertThat(devs).isEqualTo(Arrays.asList("Arie", "Mauricio"));
    }
    @Test
    public void modifiedList() {
        

        List<Estimate> list = new ArrayList<>(Arrays.asList(
            new Estimate("Arie", 5),
            new Estimate("Mauricio", 10)
        ));

        Estimate newDev = new Estimate("Guilherme", 15);
        list.add(newDev);



        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Arie", "Guilherme"));
    }
    @Test
    public void shuffledList() {

        List<Estimate> list = new ArrayList<>(Arrays.asList(
            new Estimate("Arie", 5),
            new Estimate("Mauricio", 10)
        ));

        Collections.shuffle(list);

        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Arie", "Mauricio"));
    }
    @Test
    public void repeatedValues() {
    List<Estimate> list = Arrays.asList(
        new Estimate("Arie", 5),
        new Estimate("Mauricio", 5)
    );

    List<String> devs = new PlanningPoker()
        .identifyExtremes(list);

    assertThat(devs).isEqualTo(Arrays.asList("Arie", "Mauricio"));
    }

    @Test
    public void negativeValues() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Arie", -5),
            new Estimate("Mauricio", 5)
        );

        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Arie", "Mauricio"));
    }

    @Test
    public void zeroValues() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Arie", 0),
            new Estimate("Mauricio", 5)
        );

        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Arie", "Mauricio"));
    }
    
}

// 1. does the order of the list matter?
// 2. does the size of the list matter?
// 3. does the content of the list matter?
// 4. does the type of the list matter?
// 5. does the list being empty matter?
// 6. does the list being null matter?
// 7. can the list be modified after being passed to the method?
