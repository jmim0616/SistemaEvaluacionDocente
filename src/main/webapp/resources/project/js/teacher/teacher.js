class Teacher {

    constructor() {

    	this.teacherId="asdqwe";
    	this.teacherStatus="asdqwe";
    	this.name="asdqwe";
    	this.lastName="asdqwe";
    	this.identificationType="asdqwe";
    	this.underDegree="asdqwe";
    	this.masterDegree="asdqwe";
    	this.doctorDegree="asdqwe";
    	this.institutionalMail="asdqwe";
    	this.personalMail="asdqwe";
    	this.cellPhoneNumber="asdqwe";
    	this.homeNumber="asdqwe";
    	this.experience="asdqwe";

    }

    Teacher(teacherId, teacherStatus, name, lastName, identificationType, underDegree,
    		masterDegree, doctorDegree, institutionalMail, personalMail, cellPhoneNumber,
    		homeNumber, experience) {

    	this.teacherId=teacherId;
    	this.teacherStatus=teacherStatus;
    	this.name=name;
    	this.lastName=lastName;
    	this.identificationType=identificationType;
    	this.underDegree=underDegree;
    	this.masterDegree=masterDegree;
    	this.doctorDegree=doctorDegree;
    	this.institutionalMail=institutionalMail;
    	this.personalMail=personalMail;
    	this.cellPhoneNumber=cellPhoneNumber;
    	this.homeNumber=homeNumber;
    	this.experience=experience;

    }

    set setTeacherId(teacherId) {

        this.teacherId = teacherId;
    }

    get getTeacherId() {

        return this.teacherId;
    }




    method() {
        // code
    }

    static staticMethod() {
        // code
    }

}
