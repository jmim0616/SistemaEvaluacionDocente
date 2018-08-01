class DisciplinaryArea {

    constructor() {
    	
    	this.subjectId="asdqwe";
    	this.subjectStatus="asdqwe";
    	this.disciplinaryArea="asdqwe";
    	this.name="asdqwe";
    	this.numberOfCredits="asdqwe";
    	this.academicProgram="asdqwe";
    	
    }

    DisciplinaryArea(subjectId, subjectStatus, disciplinaryArea, name, numberOfCredits, academicProgram) {

    	this.subjectId=subjectId;
    	this.subjectStatus=subjectStatus;
    	this.disciplinaryArea=disciplinaryArea;
    	this.name=name;
    	this.numberOfCredits=numberOfCredits;
    	this.academicProgram=academicProgram;

    }

    setSubjectId(subjectId) {

        this.subjectId = subjectId;
    }

    getSubjectId() {

        return this.subjectId;
    }


    method() {
        // code
    }

    static staticMethod() {
        // code
    }

}
