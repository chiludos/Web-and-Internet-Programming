package final_sample_model;

public class CourseMapping {

	private QCourse qCourse;
	private SCourse sCourse;
	
	
	public CourseMapping(QCourse qCourse,  SCourse sCourse) {
		this.qCourse = qCourse;
		this.sCourse = sCourse;
	}


	public QCourse getqCourse() {
		return qCourse;
	}


	public void setqCourse(QCourse qCourse) {
		this.qCourse = qCourse;
	}


	public SCourse getsCourse() {
		return sCourse;
	}


	public void setsCourse(SCourse sCourse) {
		this.sCourse = sCourse;
	}
}
