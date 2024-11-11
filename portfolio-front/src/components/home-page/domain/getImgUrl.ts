export function getImgUrl(pet: string) {
  const images = require.context("@/assets/", false, /\.png$/);
  return images("./" + pet + ".png");
}
