package com.test;

import org.junit.Test;
import static org.junit.Assert.*;

import com.osms.model.CourseRegistration;

public class TestCourses {
	@Test
	public void testScheduleConflict() {
		CourseRegistration coursesRegistration = new CourseRegistration();

//		addCourseOffered(int courseId, String courseName, int departmentId,
//				String professor, int labId, String courseSchedule,
//				String sessionOffered, int addDropDeadline,
//				int preRequisiteCourseId, int classCapacity)
				
		coursesRegistration.addCourseOffered(100, "SOEN 101", 100, "Prof Name", 100, "L-M---- (10:30-11:15)", "Fall", 111, 0, 20);
		coursesRegistration.addCourseOffered(101, "SOEN 102", 100, "Prof Name", 100, "L-M---- (10:30-11:15)", "Fall", 111, 0, 20);
		coursesRegistration.addCourseOffered(102, "SOEN 103", 100, "Prof Name", 100, "L-M---- (10:30-11:15)", "Fall", 111, 0, 20);
		coursesRegistration.addCourseOffered(103, "SOEN 104", 100, "Prof Name", 100, "M-W---- (13:30-14:15)", "Fall", 111, 0, 20);
		coursesRegistration.addCourseOffered(104, "SOEN 105", 100, "Prof Name", 100, "M-W---- (14:30-15:15)", "Fall", 111, 0, 20);
		coursesRegistration.addCourseOffered(105, "SOEN 106", 100, "Prof Name", 100, "-T-T--- (10:30-11:15)", "Fall", 111, 0, 20);
		coursesRegistration.addCourseOffered(106, "SOEN 107", 100, "Prof Name", 100, "-M-J--- (14:30-15:15)", "Fall", 111, 0, 20);
		coursesRegistration.addCourseOffered(107, "SOEN 108", 100, "Prof Name", 100, "----V-- (10:30-11:15)", "Fall", 111, 0, 20);

		coursesRegistration.addCourseTaken(100, "A");
		coursesRegistration.addCourseTaken(101, "A");
		coursesRegistration.addCourseTaken(102, null);
		coursesRegistration.addCourseTaken(103, null);
		coursesRegistration.addCourseTaken(104, null);
		coursesRegistration.addCourseTaken(105, null);
		coursesRegistration.addCourseTaken(106, null);
		coursesRegistration.addCourseTaken(107, null);

		// duplicate
		assertTrue(coursesRegistration
				.courseScheduleConflicts("--M---- (10:30-11:15)"));
		// schedule overlaps early
		assertTrue(coursesRegistration
				.courseScheduleConflicts("--X---- (12:00-13:45)"));
		// schedule overlaps late
		assertTrue(coursesRegistration
				.courseScheduleConflicts("--X---- (14:00-14:25)"));
		// schedule completely contains existing schedule
		assertTrue(coursesRegistration
				.courseScheduleConflicts("--X---- (13:00-15:45)"));
		// schedule is wholly within existing schedule
		assertTrue(coursesRegistration
				.courseScheduleConflicts("--X---- (14:45-15:00)"));
		// no overlap
		assertFalse(coursesRegistration
				.courseScheduleConflicts("-----S- (12:00-13:45)"));
	}
}
