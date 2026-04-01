package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipEligibilityEvaluatorTest {
    Random random = new Random();

    @Test
    void putAttLowerThanMinimum(){
        var att = random.nextDouble(75.0);
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                18,
                8.5,
                att,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=REJECTED, reasons=[Attendance rate is below the minimum required.]}", result.toString());
    }

    @Test
    void putGpaLowerThanMinimum(){
        var gpa = random.nextInt(6);
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                18,
                gpa,
                92.0,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=REJECTED, reasons=[GPA is below the minimum required.]}", result.toString());
    }

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
        Assertions.assertEquals("EvaluationResult{status=APPROVED, reasons=[Applicant meets all scholarship requirements.]}", result.toString());
    }

    @Test
    void putInvalidTypeArgumentGpa(){
        assertThrows(IllegalArgumentException.class, () -> {
            ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                    18,
                    11,
                    92.0,
                    true,
                    false
            );
        });
    }

    @Test
    void putInvalidTypeArgumentAtt(){
        assertThrows(IllegalArgumentException.class, () -> {
            ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                    18,
                    10,
                    100.1,
                    true,
                    false
            );
        });
    }

    @Test
    void putTopLimitValueGpa(){
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                18,
                10.0,
                92.0,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=APPROVED, reasons=[Applicant meets all scholarship requirements.]}", result.toString());
    }

    @Test
    void putLowLimitValueGpa(){
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                18,
                0.0,
                92.0,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=REJECTED, reasons=[GPA is below the minimum required.]}", result.toString());
    }

    @Test
    void putTopLimitValueAtt(){
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                18,
                8.5,
                100.0,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=APPROVED, reasons=[Applicant meets all scholarship requirements.]}", result.toString());
    }

    @Test
    void putLowLimitValueAtt(){
        ScholarshipEligibilityEvaluator.EvaluationResult result = ScholarshipEligibilityEvaluator.evaluateScholarship(
                18,
                8.5,
                0.0,
                true,
                false
        );
        Assertions.assertEquals("EvaluationResult{status=REJECTED, reasons=[Attendance rate is below the minimum required.]}", result.toString());
    }
}