import { Pokemon } from './pokemon';

describe('Pokemon', () => {
  it('should create an instance', () => {
    expect(new Pokemon("hi", "hi", "hi")).toBeTruthy();
  });
});
