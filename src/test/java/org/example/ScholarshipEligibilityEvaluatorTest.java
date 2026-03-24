package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipEligibilityEvaluatorTest {
    Random random = new Random();
    @Test
    void putAgeLowerThanMinimum(){
        var age = random.nextInt(15);
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                age,
                8.5,
                92.0,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=REJECTED, reasons=[Applicant is younger than the minimum age.]}", result.toString());
    }

    @Test
    void putAgeUnderThan18(){
        var age = 16 + random.nextInt(1);
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                age,
                8.5,
                92.0,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=MANUAL_REVIEW, reasons=[Applicant is under 18 and requires manual review.]}", result.toString());
    }

    @Test
    void putAgeUperThan18(){
        var age = 18 + random.nextInt(5);
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                age,
                8.5,
                92.0,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=MANUAL_REVIEW, reasons=[Applicant is under 18 and requires manual review.]}", result.toString());
    }
}