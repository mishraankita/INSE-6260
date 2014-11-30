package com.osms.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CourseRegistrationByDPD {
	public enum Status {
		NOT_TAKEN, REGISTERED, PASSED
	};

	class CourseTaken {
		private int courseID;
		private String gradeObtained;
		private String name;
		private String schedule;

		CourseTaken(int courseID, String gradeObtained, String name, String schedule) {
			this.courseID = courseID;
			this.gradeObtained = gradeObtained;
			this.name = name;
			this.schedule = schedule;
		}

		int getCourseID() {
			return courseID;
		}

		String getGradeObtained() {
			return gradeObtained;
		}
		
		String getName() {
			return name;
		}

		String getSchedule() {
			return schedule;
		}
	}
	
	class CourseOffered {
		private int courseId;
		private String courseName;
		private int departmentId;
		private String professor;
		private int labId;
		private String courseSchedule; // e.g.: ---J--- (17:45-20:15)  SGW H-603 1
		private String sessionOffered;
		private int addDropDeadline;
		private int preRequisiteCourseId;
		private int classCapacity;
		
		public final static int classCapacityMAX = 30;

		CourseOffered(int courseId, String courseName, int departmentId,
				String professor, int labId, String courseSchedule,
				String sessionOffered, int addDropDeadline,
				int preRequisiteCourseId, int classCapacity) {
			this.courseId = courseId;
			this.courseName = courseName;
			this.departmentId = departmentId;
			this.professor = professor;
			this.labId = labId;
			this.courseSchedule = courseSchedule;
			this.sessionOffered = sessionOffered;
			this.addDropDeadline = addDropDeadline;
			this.preRequisiteCourseId = preRequisiteCourseId;
			this.classCapacity = classCapacity;
		}

		int getCourseId() {
			return courseId;
		}

		String getCourseName() {
			return courseName;
		}

		String getCourseSchedule() {
			return courseSchedule;
		}

		boolean isCourseFull() {
			return classCapacity >= classCapacityMAX;
		}

		public int getPreRequisite() {
			return preRequisiteCourseId;
		}

		public int getClassSize() {
			return classCapacity;
		}
	}
	
	private List<CourseTaken> coursesTaken;
	private List<CourseOffered> coursesOffered;

	public CourseRegistrationByDPD() {
		coursesTaken = new ArrayList<CourseTaken>();
		coursesOffered = new ArrayList<CourseOffered>();
	}

	public void addCourseOffered(int courseId, String courseName, int departmentId,
			String professor, int labId, String courseSchedule,
			String sessionOffered, int addDropDeadline,
			int preRequisiteCourseId, int classCapacity) {
		coursesOffered.add(new CourseOffered(courseId, courseName, departmentId, professor,
				labId, courseSchedule, sessionOffered, addDropDeadline,
				preRequisiteCourseId, classCapacity));
	}

	public void addCourseOffered(int courseId, String courseName,
			int departmentId, String courseSchedule, String sessionOffered,
			int preRequisiteCourseId, int classCapacity) {
		addCourseOffered(courseId, courseName, departmentId, null, 0,
				courseSchedule, sessionOffered, 0, preRequisiteCourseId,
				classCapacity);
	}
			
	public void addCourseTaken(int courseId, String gradeObtained) {
		String schedule = null;
		String name = null;
		CourseOffered course = getCourseFromCoursesOffered(courseId);
		
		//If currently registered course, get the schedule from coursesOffered
		if(gradeObtained == null){
			schedule = course.getCourseSchedule();
			name = course.getCourseName();
		}
		coursesTaken.add(new CourseTaken(courseId, gradeObtained, name, schedule));
	}

	/**
	 * Determine if course is one the student is registered for. Used in
	 * building the course registration list
	 * <p>
	 * 
	 * @param courseID
	 * @return Status indicating the course is one that the student has already
	 *         passed, is registered for or, not taken.
	 */
	private Status isCourseTaken(int courseID) {
		for (ListIterator<CourseTaken> iter = coursesTaken.listIterator(); iter
				.hasNext();) {
			CourseTaken course = iter.next();
			if (course.courseID == courseID) {
				if (course.gradeObtained == null)
					return Status.REGISTERED;
				else
					return Status.PASSED;// FOR NOW ASSUME NO FAILURES
			}
		}
		return Status.NOT_TAKEN;
	}
	
	/**
	 * Determine if the provided schedule conflicts with courses taken format
	 * "-M-J--- (17:45-20:15) SGW H-603 1". The method will iterate through the
	 * courses taken, excluding courses that have a grade
	 * <p>
	 * 
	 * @param schedule
	 * @return boolean indicating if there is conflict or not
	 */
	public boolean courseScheduleConflicts(String schedule){
		for (ListIterator<CourseTaken> iter = coursesTaken.listIterator(); iter
				.hasNext();) {
			CourseTaken course = iter.next();
			//If the student already has a grade, then assume this course should not be compared.
			if(course.gradeObtained != null)
				continue;
			if( schedulesConflict(course.schedule, schedule))
				return true;
		}
		return false;
	}

	/**
	 * Utility to determine if 2 schedules conflict The schedules must be in the
	 * format "-M-J--- (17:45-20:15) SGW H-603 1"
	 * <p>
	 * 
	 * @param schedule1
	 * @param schedule2
	 * @return boolean indicating if there is conflict or not
	 */
	private boolean schedulesConflict(String schedule1, String schedule2) {
		if (schedule1 == null || schedule2 == null)
			return false;
		// ASSUME THE FOLLOWING FORMAT e.g.: -M-J--- (17:45-20:15) SGW H-603 1
		//                                   012345678901234567890
		int startTimeBeginPosition = 9;
		int startTimeEndPosition = 13;
		int endTimeBeginPosition = 15;
		int endTimeEndPosition = 19;

		// Days are in French but could be any language, we will look for '-'
		// for empty day

		// Look for conflict in days
		boolean conflict = false;
		int numberOfDays = 7;
		for (int index = 0; index < numberOfDays; index++) {
			if ((schedule1.charAt(index) != '-')
					&& (schedule2.charAt(index) != '-')) {
				conflict = true;
			}
		}
		// Look for conflict times ASSUME SAME TIME FOR THE DIFFERENT DAYS
		if (conflict == true) {
			conflict = false;
			String startTime1 = schedule1.substring(startTimeBeginPosition,
					startTimeEndPosition);
			String endTime1 = schedule1.substring(endTimeBeginPosition,
					endTimeEndPosition);
			String startTime2 = schedule2.substring(startTimeBeginPosition,
					startTimeEndPosition);
			String endTime2 = schedule2.substring(endTimeBeginPosition,
					endTimeEndPosition);

			// compareTo
			// "a".compareTo("b"); returns a negative number, here -1
			// "a".compareTo("a"); returns 0
			// "b".compareTo("a"); returns a positive number, here 1
			
			// startTime2 is during schedule1
			if ((startTime2.compareTo(startTime1) >= 0)
					&& (startTime2.compareTo(endTime1) < 0))
				conflict = true;
			// startTime1 is during schedule2
			if ((startTime1.compareTo(startTime2) >= 0)
					&& (startTime1.compareTo(endTime2) < 0))
				conflict = true;
		}
		return conflict;
	}

	/**
	 * Get schedule from coursesOffered. Used to add 'schedule' to coursesTaken
	 * to avoid always going back to coursesOffered
	 * <p>
	 * 
	 * @param courseID
	 *            The course's ID from the courses offered table
	 * @return The schedule in the format "-M-J--- (17:45-20:15) SGW H-603 1"
	 */
	private CourseOffered getCourseFromCoursesOffered(int courseID) {
		for (ListIterator<CourseOffered> iter = coursesOffered.listIterator(); iter.hasNext();) {
			CourseOffered course = iter.next();
			if (course.getCourseId() == courseID)
				return course;
		}

		return null;
	}
	
	public void buildRegistrationList(List<String> courseRegistrationList) {
		// Build list that will be used to populate the JSP
		// String will concatenate the 3 row items plus the courseID
		// Item 1 Add | Drop | Taken | Conflict | Full | No Pre-Req
		// Item 2 Course Name
		// Item 3 Course Schedule
		// Item 4 CourseID. This will be used in the action (button click)
		String lineItem = null;

		// First, at the top of the list, add all courses currently registered
		// for. For these courses (coursesTaken without grades) add a 'Drop'
		// line item
		for (ListIterator<CourseTaken> iter = coursesTaken.listIterator(); iter
				.hasNext();) {
			CourseTaken courseTaken = iter.next();
			// If the student already has a grade, then assume this course
			// should NOT be added.
			if (courseTaken.gradeObtained != null)
				continue;
			lineItem = "Drop" + "$" + courseTaken.getName() + "$"
					+ courseTaken.getSchedule() + "$"
					+ courseTaken.getCourseID();
			courseRegistrationList.add(lineItem);
		}

		// Iterate through coursesOffered
		for (ListIterator<CourseOffered> iter = coursesOffered.listIterator(); iter
				.hasNext();) {
			CourseOffered courseOffered = iter.next();
			// if course exist in coursesTaken and doesn't have a grade then
			Status takenStatus = isCourseTaken(courseOffered.getCourseId());
			// If registered, the it would be in the Drop list above - ignore
			if (takenStatus == Status.REGISTERED)
				continue;

			// If course has a grade, add as a 'Passed' line item
			if (takenStatus == Status.PASSED) {
				courseRegistrationList.add(buildLineItem("Passed", courseOffered));
				continue;
			}

			// If course has a pre-requisite
			int coursePreRequisiteID = courseOffered.getPreRequisite();
			if (coursePreRequisiteID != 0) {
				Status preReqStatus = isCourseTaken(coursePreRequisiteID);
				// if no pre-req, add line item 'No PreReq'
				if (preReqStatus == Status.NOT_TAKEN
						|| preReqStatus == Status.REGISTERED) {
					courseRegistrationList.add(buildLineItem("Add", courseOffered));
					continue;
				}
				// if (preReqStatus == Status.PASSED) then do nothing, go
				// through and verify no other constraints.
     		}

			// If class is full, add as a 'Full' line item
			if (courseOffered.getClassSize() >= CourseOffered.classCapacityMAX) {
				courseRegistrationList.add(buildLineItem("FULL", courseOffered));
				continue;
			}

			// If class conflicts with coursesTaken (the ones without grades),
			// add as 'Conflict' line item
			if (courseScheduleConflicts(courseOffered.getCourseSchedule())) {
				courseRegistrationList.add(buildLineItem("Conflict", courseOffered));
				continue;
			}

			// Add course as an 'Add' line item
			courseRegistrationList.add(buildLineItem("Add", courseOffered));
		}

		return;
	}
	
	private String buildLineItem(String label, CourseOffered courseOffered) {
		return label + "$" + courseOffered.getCourseName() + "$"
				+ courseOffered.getCourseSchedule() + "$"
				+ courseOffered.getCourseId();
	}

	public void testLoadCourseTakenDummyData() {
		// TODO Auto-generated method stub
        addCourseTaken(101, "A+");
        addCourseTaken(102, "B");
        addCourseTaken(103, null);
        addCourseTaken(104, null);
	}
}


