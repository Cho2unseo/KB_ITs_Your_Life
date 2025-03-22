import fs from 'fs/promises';

class PetAlbumManager {
  constructor() {
    this.albums = [];
    this.growth = [];
  }
  async addRecord(photo) {
    try {
      let data = [];
      try {
        const filePath = await fs.readFile('./pet_album.json', 'utf-8');
        if (filePath) {
          data = JSON.parse(filePath);
        }
      } catch (err) {
        console.error(err);
      }
      if (photo.type == 'Photo') {
        const date = this.albums.find((p) => p.uploadDate === photo.uploadDate);
        const imageroute = this.albums.find(
          (p) => p.photoPath === photo.photoPath
        );
        if (date || imageroute) {
          console.log(`[등록 오류] ${photo.name}: 중복된 사진입니다.`);
        } else {
          this.albums.push(photo);
          data.push(photo);
          console.log(`[등록 완료] ${photo.name}: Photo가 등록되었습니다.`);
          //   await fs.appendFile(
          //     './pet_album.json',
          //     JSON.stringify(this.albums, null, 2)
          //   );
          console.log(`[파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.`);
        }
      } else {
        const des = this.growth.find(
          (p) => p.description === photo.description
        );
        const record = this.growth.find(
          (p) => p.recordDate === photo.recordDate
        );
        if (des || record) {
          console.log(`[등록 오류] ${photo.name}: 중복된 성장 기록입니다.`);
        } else {
          this.growth.push(photo);
          data.push(photo);
          console.log(
            `[등록 완료] ${photo.name}: Growth Record가 등록되었습니다.`
          );
          //   await fs.appendFile(
          //     './pet_album.json',
          //     JSON.stringify(this.growth, null, 2)
          //   );
          console.log(`[파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.`);
        }
      }
      await fs.writeFile('./pet_album.json', JSON.stringify(data, null, 2));
    } catch (err) {
      console.error(err);
    }
  }
}

export { PetAlbumManager };
