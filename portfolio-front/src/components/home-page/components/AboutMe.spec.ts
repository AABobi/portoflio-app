import { shallowMount } from "@vue/test-utils";
import AboutMe from "@/components/home-page/components/AboutMe.vue";

describe("AboutMe.vue", () => {
  it("renders props.msg when passed", () => {
    const msg = "new message";
    const wrapper = shallowMount(AboutMe);
    // expect(wrapper.text()).toMatch(msg);
  });
});
