const reserveLargeRoom = () => {
  return '✅ 대형 룸이 예약되었습니다.';
};

const reserveStandardSeat = () => {
  return '✅ 일반석이 예약되었습니다.';
};

const getReservation = (people) => {
  if (people >= 5) return reserveLargeRoom();
  else return reserveStandardSeat();
};

export { getReservation };
