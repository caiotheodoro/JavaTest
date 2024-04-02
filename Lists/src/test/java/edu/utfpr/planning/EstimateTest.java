package edu.utfpr.planning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class EstimateTest {
    @Test
    void testGetDeveloper() {
        Estimate estimate = new Estimate("Mauricio", 10);
        assertThat(estimate.getDeveloper()).isEqualTo("Mauricio");

    }

    @Test
    void testGetEstimate() {
        Estimate estimate = new Estimate("Mauricio", 10);
        assertThat(estimate.getEstimate()).isEqualTo(10);

    }

    @Test
    void testSetDeveloper() {
        Estimate estimate = new Estimate("Mauricio", 10);
        estimate.setDeveloper("Arie");
        assertThat(estimate.getDeveloper()).isEqualTo("Arie");

    }

    @Test
    void testSetEstimate() {
        Estimate estimate = new Estimate("Mauricio", 10);
        estimate.setEstimate(5);
        assertThat(estimate.getEstimate()).isEqualTo(5);

    }
}
