import fs from 'fs/promises';

class EducationManager {
  constructor() {
    this.programs = [];
  }
  registerProgram(program) {
    this.programs.push(program);
    console.log(`[등록 완료] 교육 과정: ${program.title}`);
  }
  completeProgramWithFuction(title) {
    const program = this.programs.find((p) => p.title === title);
    program.isCompleted = true;
    console.log(`[이수 완료 - 일반 함수] ${title}`);
  }
  completeProgramWithArrowFunction = (title) => {
    const program = this.programs.find((p) => p.title === title);
    program.isCompleted = true;
    console.log(`[이수 완료 - 화살표 함수] ${title}`);
  };
  async saveToFile() {
    try {
      await fs.writeFile(
        './education_records.json',
        JSON.stringify(this.programs, null, 2)
      );
      console.log(`[파일 저장 완료] 교육 기록이 파일로 저장되었습니다.`);
    } catch (err) {
      console.error(err);
    }
  }
}

export { EducationManager };
