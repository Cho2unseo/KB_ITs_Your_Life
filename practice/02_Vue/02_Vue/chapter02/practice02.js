class Item {
  constructor(name, type, stock, alreadyWarned) {
    this.name = name;
    this.type = type;
    this.stock = stock;
    this.alreadyWarned = alreadyWarned;
  }
}

class InventoryManager {
  constructor() {
    this.items = [];
  }
  addItem(item) {
    this.items.push(item);
    console.log(`[추가] ${item.type} - ${item.name} (재고: ${item.stock})`);
  }
  updateStock(item, count) {
    if (count < 0) console.log('[업데이트 오류] 재고는 0 이상이어야 합니다.');
    else {
      console.log(`[업데이트] ${item} 재고: ${count}개`);
      if (count < 5)
        console.log(`[재고 부족 경고] ${item}: 재고가 5개 미만입니다!`);
    }
  }
  checkStock() {
    var interval = setInterval(() => {
      this.items.forEach((item) => {
        if (!item.alreadyWarned) {
          console.log(`[자동 경고] ${item.name}: 재고가 5개 미만입니다!`);
          item.alreadyWarned = true;
        }
      });
    }, 1000);
    setTimeout(() => {
      clearInterval(interval);
      console.log('[재고 검사 종료]');
    }, 5000);
  }
}

const inventory = new InventoryManager();
const item1 = new Item('고급 고양이 사료', '사료', 10);
inventory.addItem(item1);
inventory.updateStock('고급 고양이 사료', 4);
inventory.updateStock('고급 고양이 사료', -1);

inventory.checkStock();
