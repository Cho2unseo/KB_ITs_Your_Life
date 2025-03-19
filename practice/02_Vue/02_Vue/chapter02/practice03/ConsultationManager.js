class ConsultationManager {
  constructor() {
    this.people = [];
  }
  registerConsultation(customer) {
    // 1초 후 자동 저장 하도록 수정 필요
    const regex = /^010-\d{4}-\d{4}$/;
    setTimeout(() => {
      if (regex.test(customer.contact)) {
        // 중복되는 전화번호 있는지 확인
        for (let value of Object.values(this.people)) {
          if (value.contact == customer.contact) {
            console.log(
              `[상담 중복 오류] ${customer.name}: 이미 등록된 상담 기록입니다.`
            );
            return;
          }
        }
        this.people.push(customer);
        console.log(`[상담 등록] ${customer.name} - 선호 펫: ${customer.pet}`);
      } else {
        console.log(
          `[상담 등록 오류] ${customer.name}: 잘못된 전화번호 형식입니다.`
        );
      }
    }, 1000);
  }
  autoEndConsulation() {
    setTimeout(() => {
      console.log('[상담 기록 저장 종료]');
    }, 5000);
  }
}

export { ConsultationManager };
