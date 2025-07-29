<script setup>
import { reactive, ref } from 'vue';
import { KakaoMap, KakaoMapMarker } from 'vue3-kakao-maps';

const props = defineProps({
  title: { Type: String, required: true },
  address: { Type: String, required: true },
});

const coordinate = reactive({
  lat: 37.566826,
  lng: 126.9786567,
});

const map = ref();

const onLoadKakaoMap = (mapRef) => {
  map.value = mapRef;
  const getcoder = new kakao.maps.services.Geocoder();

  getcoder.addressSearch(props.address, (result, status) => {
    if (status === kakao.maps.services.Status.OK) {
      coordinate.lat = result[0].y;
      coordinate.lng = result[0].x;
    }
  });
};

const visibleRef = ref(false);

const onClickKakaoMapMarker = () => {
  visibleRef.value = !visibleRef.value;
};
</script>

<template>
  <div><i class="fa-solid fa-map-location-dot"></i> {{ address }}</div>
  <kakao-map
    :lat="coordinate.lat"
    :lng="coordinate.lng"
    :level="3"
    :draggable="true"
    style="width: 100%"
    @onLoadKakaoMap="onLoadKakaoMap"
  >
    <kakao-map-marker
      :lat="coordinate.lat"
      :lng="coordinate.lng"
      :infoWindow="{ content: title, visible: visibleRef }"
      :clickable="true"
      @onClickKakaoMapMarker="onClickKakaoMapMarker"
    />
    />
  </kakao-map>
</template>
